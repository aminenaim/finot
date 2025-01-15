from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()


class DataPayload(BaseModel):
    data: str


@app.post("/process-data")
async def process_data(payload: DataPayload):
    processed = f"Traitement de {payload.data}"
    return {"result": processed}