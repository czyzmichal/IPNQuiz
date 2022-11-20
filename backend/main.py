import sys
import os

sys.path.append(str(os.getcwd()))

from typing import List

from fastapi import Depends, FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from sqlalchemy.orm import Session, Query
from starlette.responses import RedirectResponse

import models
import schemas

from parser import IPNParser

from database import SessionLocal, engine

models.Base.metadata.create_all(bind=engine)

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_methods=["*"],
    allow_headers=["*"],
    allow_credentials=True,
)

# Dependency
def get_db():
    try:
        db = SessionLocal()
        yield db
    finally:
        db.close()


@app.get("/")
async def main():
    return RedirectResponse(url="/docs/")


@app.get("/quizes/", response_model=List[schemas.Quiz])
async def show_records(db: Session = Depends(get_db)):
    quizes = db.query(models.Quiz).all()
    return quizes


@app.post("/register/", response_model=schemas.User)
def create_user(
    username: str,
    first_name: str,
    last_name: str,
    password: str,
    db: Session = Depends(get_db),
):
    db_user = db.query(models.User).filter_by(username=username)

    if db_user:
        raise HTTPException(
            status_code=400, detail="User with this username already exists!"
        )

    db_user = models.User(
        username=username,
        first_name=first_name,
        last_name=last_name,
        password=password,
    )
    db.add(db_user)
    db.commit()
    db.refresh(db_user)
    return db_user


@app.post("/login/")
async def login(username: str, password: str, db: models.User = Depends(get_db)):
    print(username, password)
    users: Query = db.query(models.User).filter(models.User.username == username)

    if not users:
        return HTTPException(status_code=400, detail="User or password incorrect")

    user = users.first()

    if user.password != password:
        return HTTPException(status_code=400, detail="User or password incorrect")

    return user


@app.post("/users/")
async def login(db: models.User = Depends(get_db)):
    users = db.query(models.User).all()
    return users


@app.post("/search_for_phrase/")
async def create_quiz(quiz_phrase: str, db: models.Quiz = Depends(get_db)):
    parser = IPNParser()
    phrasesWithSentces = parser.getKeyWordsForPhrase(quiz_phrase)
    return phrasesWithSentces
