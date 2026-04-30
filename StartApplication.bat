@echo off
docker compose up --build -d
timeout /t 5
start http://localhost