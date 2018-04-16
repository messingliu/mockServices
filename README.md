Build:
gradle build


Run:
./gradlew bootRun

go to browser or curl:
http://localhost:8010/mockMerger?search=suggested,scenario-suggested&filter=&with=contacts,questions,scenarios,user.publicMoments,relationships&user_id=1&limit=10
http://localhost:8010/mockDelay?delay=200

return
[2,3,4,8]


Features are mocked data

Log data in /var/log/mockServices.log

run ./gradlew bootRun --debug to show print out log

# mockServices
