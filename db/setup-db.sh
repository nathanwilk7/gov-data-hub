dbname=govdatahub
dropdb $dbname || true
createdb $dbname
psql -f init.sql $dbname
