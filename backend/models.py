from sqlalchemy import Column, Integer, String, ARRAY
from sqlalchemy.types import Date
from database import Base


class Quiz(Base):
    __tablename__ = "quiz"

    id = Column(Integer, primary_key=True, index=True)
    name = Column(String(80), index=True)
    date_created = Column(Date)


class Question(Base):
    __tablename__ = "question"

    id = Column(Integer, primary_key=True, index=True)
    question = Column(String(255))
    correct_answer = Column(String(255))
    incorrect_answers = Column(ARRAY(String))


class User(Base):
    __tablename__ = "user"

    id = Column(Integer, primary_key=True, index=True)
    username = Column(String(50))
    first_name = Column(String(50))
    last_name = Column(String(50))
    password = Column(String(30))
