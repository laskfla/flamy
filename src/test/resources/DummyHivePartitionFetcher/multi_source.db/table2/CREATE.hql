CREATE TABLE IF NOT EXISTS multi_source.table2(
  id STRING  
)
PARTITIONED BY (part1 STRING, part2 STRING)
;
