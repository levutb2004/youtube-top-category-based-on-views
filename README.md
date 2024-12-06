YouTube Data Analysis
This project analyzes YouTube data to determine the most popular genres in the US based on views using a MapReduce model. The input dataset is USvideos0.csv, and the analysis is executed on a Hadoop cluster.

📂 Dataset
Input Dataset: USvideos0.csv
This dataset contains YouTube video data, including details about video categories and views.
🗂️ Project Structure
Input Directory in HDFS: /YouTubeInput
Output Directory in HDFS: /YouTubeOutput
JAR File: TopCategory.jar
🛠️ Setting Up and Running the Analysis
Follow the steps below to run the project and get the results.

1. Create an Input Directory in Hadoop Filesystem
First, create a directory in HDFS where the input data will reside.

bash
Copy code
hdfs dfs -mkdir /YouTubeInput
2. Upload Input Data to HDFS
Place the input data (USvideos0.csv) from your local Linux filesystem to the Hadoop DFS.

bash
Copy code
hdfs dfs -put /Downloads/youtube-top-category-based-on-views/USvideos0.csv /YouTubeInput
3. Run the MapReduce Job
Create and execute your JAR file to process the data and save the output to the designated output directory in HDFS.

bash
Copy code
hadoop jar /home/hadoop/TopCategory.jar PopularVideosJob /YouTubeInput /YouTubeOutput
4. View the Results in HDFS
To check the output files stored in the HDFS output directory:

bash
Copy code
hdfs dfs -cat /YouTubeOutput/*
5. Retrieve the Results to Local Filesystem
Finally, get the results from HDFS and place them in your local filesystem for further analysis or visualization.

bash
Copy code
hdfs dfs -get /YouTubeOutput/* /Downloads/youtube-top-category-based-on-view/TopCategoryOutput
📊 Output
After running the job, you will get the output files located in:

bash
Copy code
/Downloads/youtube-top-category-based-on-view/TopCategoryOutput
These files contain information about the top categories on YouTube in terms of views across different genres in the US.
