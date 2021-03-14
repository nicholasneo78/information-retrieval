# Solr
## Standalone vs SolrCloud
- [X] `Standalone` refer to only single machine hosting solr server  
- [ ] `SolrCloud` refer to multiple machines hosting solr server (distributed system [see more][5])

## Core vs Collection
Both `Core` and `Collection` refer to document collection in Solr. 
- [X] `Core` is for `Standalone`
- [ ] `Collection` is for `SolrCloud`, where single index is distributed to multiple server

## Schema
- [X] `managed-schema`: aka `schemaless` implementation. Solr analysis the document when uploaded, fields are added when neceaary. (do not manually change the file, chaning the field should always use `web admin ui` or `schemaAPI`, [see more][6] )
- [ ] `schema.xml`: traditional way to manage schma, manual edition by user 

---
## Requirement ([see][1])
Java Runtime Environment (JRE) version 1.8  or higher 

## Setting up environment
* create local variable `SOLR` like following  
<img src="res/env1.png" width="400"/>  

* putting `solr\bin` folder into your path variable  
<img src="res/env2.png" width="400"/>


## Starting of Solr server
* use command line to rediret to *solr home* directory
* using `solr start` to start the server
* after the server is started, enter the admin panel with url `localhost:8983\solr`
* `<solr home>\server\solr` is where we need to manage  
<img src="res/start.png" width="400"/>

## Creating the new core and post data into solr server
* core is used to index and keep documentation
* usually core located at `<solr home>\server\solr\<core name>`
* `<core name>\conf`: keep configurations. preprocessing relatede configuration might be adjust here
* `<core name>\data`: keep indexed data.  
<img src="res/new_core.png" width="400"/>

## Posting of documents ([see][2])
* Mac user can use `bin\post` (Unix shell script) to post documents to solr server
* Windwos OS need to use `post.jar` (located at `<solr home>\example\exampledocs\post.jar`), or `curl` command to push document
<img src="res/post.png" width="400"/>





[1]: https://lucene.apache.org/solr/guide/8_8/solr-system-requirements.html
[2]: https://lucene.apache.org/solr/guide/8_8/post-tool.html


[5]: https://solr.apache.org/guide/8_8/solrcloud.html
[6]: https://solr.apache.org/guide/8_8/schema-api.html#schema-api

