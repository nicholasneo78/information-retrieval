# Schema
Schema defineds fields that used in the system, and how the pre-processing is performed by each field  


## Field 

[`Cope Field`](https://youtu.be/6NQTaVeFEG0): with one field mapping to one or more fields.  
- works best for `df` parameter to catch all fields
- may leads great increase in index size





# Pre-processing([See][1])
## Analyzers
Define the rules to perform pre-processing on document/query by listing tokenizer and filters.
* `document` and `query` may apply different set of rules
   

## Tokenizers ([See][2])
Read in document, and convert into list of tokens. Each tokenizer have differnt way to break down sentences, some may keep numbers and date.


## Filters ([See][3])
Performs linguistic analysis on tokens, apply rules like normalization, lemmetization or stemming to modify or remove tokens before passing to index writer


## To read up
* [schema design][11]
* [indexing][12]


[1]: https://solr.apache.org/guide/8_8/understanding-analyzers-tokenizers-and-filters.html
[2]: https://solr.apache.org/guide/8_8/tokenizers.html
[3]: https://solr.apache.org/guide/8_8/filter-descriptions.html

[11]: https://lucene.apache.org/solr/guide/8_8/documents-fields-and-schema-design.html
[12]: https://lucene.apache.org/solr/guide/8_8/indexing-and-basic-data-operations.html



