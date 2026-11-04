@echo off
chcp 65001 > nul
echo Celestia 모드를 빌드합니다. 처음에는 몇 분 걸려요...
call gradlew.bat build
if errorlevel 1 (
  echo.
  echo [빌드 실패] 위의 빨간 에러 내용을 복사해서 Claude에게 보내주세요.
  pause
  exit /b 1
)
echo.
echo [완료] build\libs 폴더에 celestia-0.1.0.jar 가 생겼어요.
explorer build\libs
pause
