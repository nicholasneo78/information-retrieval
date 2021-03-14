# Query
## Query parameters
`q`: query terms, find matching document and calculate for relevancy score
> usually in the format of `q=field:value`

`fq`: filter query, very similar to `q` expression, however it has following characteristics
* has no effect on relevancy
* cache the results  
  
`sort`: enter with field name to allow solr order the document based on the field  
`fl`: field list, to allow showing of limited fields only
> To show only name, type and score on response,  
> localhost:8983/solr/`core_name`/select?`fl=name%2Ctype%2Cscore`&q=\*%3A\*

`df`: default search **field** if q does not provide which field to search for.
> To always search on name field, if no field provided,  
> localhost:8983/solr/`core_name`/select?`df=name`&q=best
---
## Advanced query
`facet`
> localhost:8983/solr/`core_name`/select?`facet.field=type&facet=on`&q=\*%3A\*  
<!-- Add spell checks? -->
## Reference:  
* [tutorial](https://youtu.be/Zw4M4NGv-Rw?t=618)