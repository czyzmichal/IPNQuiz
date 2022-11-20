#!/bin/bash

PROJECT_DIR=$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)

export DB_CONN="sqlite:///db.db"

function install_uvicorn() {
    cd "${PROJECT_DIR}/backend"

    python3 -m venv venv

    source "venv/bin/activate"

    pip install wheel
    pip install "fastapi[All]"
    pip install -r "${PROJECT_DIR}/backend/requirements.txt"
    pip install "uvicorn[standard]"

    deactivate
}

function run_fastapi() {
    source "${PROJECT_DIR}/backend/venv/bin/activate"
    cd "${PROJECT_DIR}/backend"
    uvicorn main:app --reload
}

function run_postgres() {
    docker run \
        -e POSTGRES_PASSWORD=postgres \
        -e POSTGRES_USER=postgres \
        -e POSTGRES_DB=postgres \
        -p 5432:5432 \
        -d postgres
}

function install_postgres() {
    docker pull postgres
}
