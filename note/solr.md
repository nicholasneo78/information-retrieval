# Solr

## Requirement ([see][1])

Java Runtime Environment (JRE) version 1.8  or higher 

### Setting up environment

* create local variable `SOLR` like following  
  <img src="res/env1.png" width="400"/>  
* putting `solr\bin` folder into your path variable  
  <img src="res/env2.png" width="400"/>




## Solr server
### Standalone vs SolrCloud
- [X] `Standalone` refer to only single machine hosting solr server  
- [ ] `SolrCloud` refer to multiple machines hosting solr server (distributed system [see more][5])

### Running of Solr server
* use command line to redirect to *solr home* directory
* using `solr start` to start the server
* after the server is started, enter the admin panel with url `localhost:8983\solr`
* `<solr home>\server\solr` is where we need to manage  

```shell
solr start

solr stop -all
```



## Data management 
### Core vs Collection
Both `Core` and `Collection` refer to document collection in Solr. 
- [X] `Core` is for `Standalone`
- [ ] `Collection` is for `SolrCloud`, where single index is distributed to multiple server

### Core 
* core is used to index and keep documentation
* usually core located at `<solr home>\server\solr\<core name>`
* `<core name>\conf`: keep configurations. preprocessing related configuration might be adjust here
* `<core name>\data`: keep indexed data.

``` shell
solr create_core -c restaurant
solr delete -c restaurant
```

### Post data into Solr server ([see][2])
Solr will automatically analysis document to decide field types with appropriate field type if schemaless implementation is adopted. Pre-defining the fields can prevent wrong recognition on field type.

* Mac user can use `bin\post` (Unix shell script) to post documents to solr server
* Windwos OS need to use `post.jar` (located at `<solr home>\example\exampledocs\post.jar`), or `curl` command to push document

```shell
curl "http://localhost:8983/solr/restaurant/update?commit=true&f.type.split=true&f.type.separator=%2C" -H "Content-Type:application/csv" --data-binary @C:\Users\chiayu\Desktop\IR\main.csv
```
```shell
curl "http://localhost:8983/solr/comment/update?commit=true" -H "Content-Type:application/csv" --data-binary @C:\Users\chiayu\Desktop\IR\comment.csv
```




## Schema
- [X] `managed-schema`: aka `schemaless` implementation. Solr analysis the document when uploaded, fields are added when necessary. (do not manually change the file, changing the field should always use `web admin ui` or `schemaAPI` [see][6]  )
- [ ] `schema.xml`: traditional way to manage schema, manual edition by user 



[1]: https://lucene.apache.org/solr/guide/8_8/solr-system-requirements.html
[2]: https://lucene.apache.org/solr/guide/8_8/post-tool.html


[5]: https://solr.apache.org/guide/8_8/solrcloud.html
[6]: https://solr.apache.org/guide/8_8/schema-api.html#schema-api

