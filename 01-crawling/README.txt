** README prepared by Nicholas Neo **

This is the README for the source code portion of the CE/CZ4034 assignment

This README file will be in the same directory as the root folder
Root Folder: 4034-group-7-assignment-source-code/

Source code in this folder will generate data that is situated in the data folder 
Data Root Folder (another zip folder): 4034-group-7-assignment-data/

For simplicity, when referencing to data files generated from the source code files, 
the root folder of the data will be denoted as [DATA]/
Example: 4034-group-7-assignment-data/a.csv => [DATA]/a.csv

Any relative path stated in this README is with reference to the root folder
Example: ./a.ipynb => 4034-group-7-assignment-source-code/a.ipynb

NOTE:
WHEN RUNNING THE NOTEBOOKS, THE DATA FILES WILL BE GENERATED IN THE DATA SUBFOLDER OF THE
CRAWLING OR THE CLASSIFICATION PORTION. 
i.e. data will be generated into either ./crawling/data or ./classification/4034-amazon-review-classification/data

THE NOTEBOOKS BELOW ARE RAN EITHER FROM JUPYTER NOTEBOOK OR GOOGLE COLABORATORY (WILL STATE CLEARLY FOR EACH CODE) 

FOR THE SOLR AND UI PORTION, REFER TO ./solr-and-ui/instructions.pdf for the guide 
to install solr and our run our GUI application.


** EXPLANATION OF THE SOURCE CODES USED IN THIS ASSIGNMENT **

----- CRAWLING OF DATA -----

** LIBRARIES USED IN THIS SECTION **

- requests
- matplotlib
- BeautifulSoup
- pandas
- time
- random
- warnings
- datetime
- re

** LIBRARIES USED END **

##### FIRST-LEVEL CRAWLING #####
./crawling/trip-advisor-scraper-main.ipynb
- CODED IN JUPYTER NOTEBOOK
- The crawler code to do a first level crawling to crawl data which includes:
	- Restaurant Name
	- Restaurant Type
	- Webpage of the restaurant
- This code will generate ./crawling/data/trip-advisor-scraper-main-url.csv, same file as [DATA]/crawling/trip-advisor-scraper-main-url.csv


##### SECOND-LEVEL CRAWLING #####
./crawling/trip-advisor-scraper-comments.ipynb
- CODED IN JUPYTER NOTEBOOK
- The crawler code to do a second level crawling to crawl data which includes:
	- Restaurant Name (adapted from first level crawl)
	- Restaurant Type (adapted from first level crawl)
	- Reviewer's Name
	- Rating
	- Comment
- This code will generate ./crawling/data/trip-advisor-comments.csv, same file as [DATA]/crawling/trip-advisor-comments.csv

----- CRAWLING OF DATA END -----


----- INDEXING AND QUERYING -----

** LIBRARIES USED IN THIS SECTION **
 -- refer to the ./solr-and-ui/instructions.pdf for instructions
** LIBRARIES USED END **

./solr-and-ui/solr-8.8.0/
- configuration folder for our solr implementation

./solr-and-ui/gui.ipynb
- file to launch our user interface (application)

./solr-and-ui/ir_env.yml
- configuration file to set up the dependencies required to launch our user interface

./solr-and-ui/instructions.pdf
- step-by-step instructions to set up the environment for solr and the user interface for our application

----- INDEXING AND QUERYING -----


----- CLASSIFICATION -----

For this section, most of the codes are run in google colaboratory, 
except for inter-annotator agreement which is ran using jupyter notebook
Hence, if you want to run the codes, is best to copy the whole of the 4034-amazon-review-classification/ 
subfolder into google drive's root folder (all codes in this subfolder are coded in google colaboratory).

NOTE: 
ALL THE SAVED WEIGHTS GENERATED HERE WILL NOT BE NOT INCLUDED IN THIS ZIP FOLDER 
AS THE FILE SIZE WILL BE TOO LARGE FOR MY GOOGLE DRIVE, 
HENCE, I'LL PUT THE SAVED WEIGHTS INTO ANOTHER FOLDER AND HOW TO USE IT, IF YOU WANT TO SEE IT.
WILL STATE IN THE REPORT.

** LIBRARIES USED IN THIS SECTION **

- ktrain
- warnings
- sqlite3
- pandas
- numpy
- nltk
- string
- matplotlib
- seaborn
- bs4
- sklearn
- re
- tqdm
- gensim
- pickle
- os
- tensorflow
- ghostscript
- spacy
- pprint
- spacy
- collections
- en_core_web_sm
- sys
- seaborn

** LIBRARIES USED END **

##### INFORMATION EXTRACTION #####
./classification/4034-amazon-review-classification/text_summarization.ipynb
- CODED IN GOOGLE COLABORATORY
- Source code to do abstractive text summarization
- generates 4 intermediate data files:
	- ./classification/4034-amazon-review-classification/data/text_summarization_data_lite.csv
	- ./classification/4034-amazon-review-classification/data/text_summarization_data_test_analysis.csv
	- ./classification/4034-amazon-review-classification/data/text_summarization_data_test_lite.csv
	- ./classification/4034-amazon-review-classification/data/text_summarization_data_val_analysis.csv
	WHICH IS THE SAME FILE AS 
	- [DATA]/classification/text_summarization_data_lite.csv
	- [DATA]/classification/text_summarization_data_test_analysis.csv
	- [DATA]/classification/text_summarization_data_test_lite.csv
	- [DATA]/classification/text_summarization_data_val_analysis.csv
	

./classification/4034-amazon-review-classification/attention.py
- a pre-written file to enable keras to have customed attention layer in text summarization subtask
- used in ./classification/4034-amazon-review-classification/text_summarization.ipynb
	

./classification/4034-amazon-review-classification/sentence_segmentation.ipynb
- CODED IN GOOGLE COLABORATORY
- Source code to do sentence segmentation

##### SENTIMENT CLASSIFICATION #####
./classification/4034-amazon-review-classification/amazon_review_dataset_2_class_downsampled.ipynb
- CODED IN GOOGLE COLABORATORY
- Source code to do the main task, which is sentiment classification
- generates 5 intermediate data files:
	- ./classification/4034-amazon-review-classification/data/trip-advisor-comments-filtered.csv
	- ./classification/4034-amazon-review-classification/data/data_train_test_combined.csv
	- ./classification/4034-amazon-review-classification/data/data_with_actual_and_pred.csv
	- ./classification/4034-amazon-review-classification/data/data_for_solr_updated.csv
	- ./classification/4034-amazon-review-classification/data/trip-advisor-comments-filtered-ordered.csv
	WHICH IS THE SAME FILE AS 
	- [DATA]/classification/trip-advisor-comments-filtered.csv
	- [DATA]/classification/data_train_test_combined.csv
	- [DATA]/classification/data_with_actual_and_pred.csv
	- [DATA]/classification/data_for_solr_updated.csv
	- [DATA]/classification/trip-advisor-comments-filtered-ordered.csv

##### INTER-ANNOTATOR AGREEMENT #####
./classification/inter-annotator-agreement-data-code.ipynb
- CODED IN JUPYTER NOTEBOOK
- Source code to generate 1000 data entries for inter-annotator agreement
- generates 1 data file:
	- ./classification/data/sampled-data-for-annotation.csv
	WHICH IS THE SAME FILE AS 
	- [DATA]/classification/sampled-data-for-annotation.csv


./classification/inter-annotator-agreement-kappa-score.ipynb
- CODED IN JUPYTER NOTEBOOK
- Imports ./classification/data/sampled-data-for-annotation-after-annotation.csv
- Source code to determine the cohen-kappa score and the confusion matrix of disagreements

##### ENHANCHING CLASSIFICATION #####
./classification/4034-amazon-review-classification/aspect_based_sentiment_analysis.ipynb
- CODED IN GOOGLE COLABORATORY
- Source code to do aspect-based sentiment analysis
- generates 1 intermediate data file:
	- ./classification/4034-amazon-review-classification/data/data_test_absa.csv
	WHICH IS THE SAME FILE AS 
	- [DATA]/classification/data_test_absa.csv


./classification/4034-amazon-review-classification/named_entity_recognition.ipynb
- CODED IN GOOGLE COLABORATORY
- Source code to do named-entity recognition

----- CLASSIFICATION END -----