Just a quick demo on Hazelcast MapStore and CDC using PostgreSQL.
To run the demo:
1. Set the license key `export HZ_LICENSEKEY=$(cat ~/hazelcast/demo.license)`
1. Start three Hazelcast and Postgres `docker-compose up -d`

We will use auto mapping of Postgres table `dashboard` and Hazelcast map `dashboard` and use the `GenericMapStore` to cache and write-through data to Postgres.
### Mapping
1. We used [GenericMapStore](https://docs.hazelcast.com/hazelcast/5.4/mapstore/configuring-a-generic-mapstore) to cache and write-through (default behaviour) data to postgres.
1. In such cases Hazelcast will create mapping on its own as documented [here](https://docs.hazelcast.com/hazelcast/5.4/sql/mapping-to-jdbc). Note the [mapping](https://docs.hazelcast.com/hazelcast/5.4/sql/mapping-to-jdbc#data-type-mapping-between-hazelcast-and-postgresql) that gets created is between Hazelcast and Postgres.
1. The automatic mapping created by Hazelcast called `__map-store.dashboard` which you can use when using SQL. Basically this is a mapping to the Postgre table `dashboard` and not the hazelcast map `dashboard`.
1. Take note of the `map` named `dashboard` in file `hazelcast.yaml`. For any need to modify the default configuration take note of the choices available [here](https://docs.hazelcast.com/hazelcast/5.4/mapstore/configuring-a-generic-mapstore#configuration-properties-for-the-generic-mapstore).
1. We have configured `dashboard` map to load eagerly but it loads only when the map is called for the first time. You can do that via the `Client` class or using [Hazelcast CLC](https://docs.hazelcast.com/clc/latest/overview) and execute `clc -c dev map -n dashboard key-set`

### Java
While the section above created a cache with low code but in order to query the cache in Java you can use either no-code Compact Seriraliation or custom Compact Serialization.
Class `GenericClient` uses no-code Compact Serialization to query the cache.
TODO: Add custom Compact Serialization example.
