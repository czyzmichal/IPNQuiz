from datetime import date
from pydantic import BaseModel
from typing import List


class Quiz(BaseModel):
    id: int
    name: str
    date: date

    class Config:
        orm_mode = True


class Question(BaseModel):
    id: int
    question: str
    correct_answer: str
    incorrect_answers: List[str]

    class Config:
        orm_mode = True


class User(BaseModel):
    id: int
    username: str
    first_name: str
    last_name: str
    password: str

    class Config:
        orm_mode = True
