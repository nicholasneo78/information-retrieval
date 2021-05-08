# Schema
Schema defines fields that used in the system, and how the pre-processing is performed by each field  


## Field 
[`Cope Field`](https://youtu.be/6NQTaVeFEG0): with one field mapping to one or more fields.  

* require to create `destination field` first before adding copy field

- works best for `df` parameter to catch all fields
- may leads great increase in index size
-  by default Solr configure `_text_` as default field, hence it is good to set `_text_` as copy field.

```xml
<!-- solrconfig.xml -->
<initParams path="/update/**,/query,/select,/spell">
    <lst name="defaults">
        <str name="df">_text_</str>
    </lst>
</initParams>
```



# Pre-processing([See][1])

Solr allow configure different kind of pre-processing methods for indexing and querying for each field type.

```xml
<!-- managed-schema/schema.xml -->
<fieldType name="text_en" class="solr.TextField" positionIncrementGap="100">
    <analyzer type="index">
        <tokenizer class="solr.StandardTokenizerFactory"/>
        <filter class="solr.StopFilterFactory" words="lang/stopwords_en.txt" ignoreCase="true"/>
        <filter class="solr.LowerCaseFilterFactory"/>
        <filter class="solr.EnglishPossessiveFilterFactory"/>
        <filter class="solr.KeywordMarkerFilterFactory" protected="protwords.txt"/>
        <filter class="solr.PorterStemFilterFactory"/>
    </analyzer>
    <analyzer type="query">
        <tokenizer class="solr.StandardTokenizerFactory"/>
        <filter class="solr.SynonymGraphFilterFactory" expand="true" ignoreCase="true" synonyms="synonyms.txt"/>
        <filter class="solr.StopFilterFactory" words="lang/stopwords_en.txt" ignoreCase="true"/>
        <filter class="solr.LowerCaseFilterFactory"/>
        <filter class="solr.EnglishPossessiveFilterFactory"/>
        <filter class="solr.KeywordMarkerFilterFactory" protected="protwords.txt"/>
        <filter class="solr.PorterStemFilterFactory"/>
    </analyzer>
</fieldType>
```





## Analyzers ([See][2])
Define the rules to perform pre-processing on document/query by listing tokenizer and filters.
* `document` and `query` may apply different set of rules

## Tokenizers ([See][3])
Read in document, and convert into list of tokens. Each tokenizer have different way to break down sentences, some may keep numbers and date.


## Filters ([See][4])
Performs linguistic analysis on tokens, apply rules like normalization, lemmatization or stemming to modify or remove tokens before passing to index writer





# Configuration



Deduplicate: https://solr.apache.org/guide/8_8/de-duplication.html#configuration-options

Spell checking: https://solr.apache.org/guide/8_8/spell-checking.html




## To read up
* [schema design][11]
* [indexing][12]


[1]: https://solr.apache.org/guide/8_8/understanding-analyzers-tokenizers-and-filters.html
[2]:https://solr.apache.org/guide/8_8/analyzers.html
[3]: https://solr.apache.org/guide/8_8/tokenizers.html
[4]: https://solr.apache.org/guide/8_8/filter-descriptions.html



[11]: https://lucene.apache.org/solr/guide/8_8/documents-fields-and-schema-design.html
[12]: https://lucene.apache.org/solr/guide/8_8/indexing-and-basic-data-operations.html



