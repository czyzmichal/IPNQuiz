#!/bin/bash

PROJECT_DIR=$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)

export DB_CONN="sqlite:///db.db"

function install_uvicorn() {
    source "${PROJECT_DIR}/backend/venv/activate"

    pip install -r "${PROJECT_DIR}/requirements.txt"
    pip install "uvicorn[standard]"

    deactivate
}

function run_fastapi() {
    cd "${PROJECT_DIR}/backend"
    uvicorn main:app --reload

    cd --
}
