cd /opt/test
docker build -t moon .
docker run -dit -p 1234:80 moon
