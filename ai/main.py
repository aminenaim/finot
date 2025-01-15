from fastapi import FastAPI
from pydantic import BaseModel
from langchain_mistralai import ChatMistralAI

import getpass
import os

if "MISTRAL_API_KEY" not in os.environ:
    os.environ["MISTRAL_API_KEY"] = getpass.getpass("Enter your Mistral API key: ")
    
app = FastAPI()


class DataPayload(BaseModel):
    data: str


@app.post("/request")
async def request(payload: DataPayload):
    processed = f"Traitement de {payload.data}"
    
    llm = ChatMistralAI(
        model="ministral-8b-latest",
    )
    
    messages = [
        (
            "system",
            "Tu es un assistant pédagogique à destination des enseignants. Sois courtois, précis et ne diffuse que des informations.",
        ),
        ("human", payload.data),
    ]
    
    llm_response = llm.invoke(messages)
    
    processed = f"{llm_response.content}"
    
    return {"result": processed}