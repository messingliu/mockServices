Build:
gradle build


Run:
./gradlew bootRun

go to browser or curl:
http://localhost:8010/users?search=suggested,scenario-suggested&filter=&with=contacts,questions,scenarios,user.publicMoments,relationships&user_id=1&limit=10
http://localhost:8010/mockDelay?delay=200

To call mockMerger, change ableToCallMerger in l2-mt to false
Log data in /var/log/mockServices.log

run ./gradlew bootRun --debug to show print out log

# mockServices
