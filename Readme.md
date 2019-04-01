# Top Download App

This application will be capable of displaying top downloaded list using RSS feeds from Apple. It will give user the option to chose from free app / Paid apps / Songs from the menu with also the option to chose amount of result between 25 or 10. 

### Applicaiton feature

* List of top free apps
* List of top paid apps
* List of top songs
* Option to chose amoung to result. (25 / 10)

### Java classes and there roles

1. MainActivity
	- Display menu and pass the chosen option to correct class for download
	- Create http connection download the feeds using parameter given from menu option.
	- Pass the feeds to ParseApplication class to parse to feedEntry.
2. ParseApplicaiton
	- Evaluate the feeds using xmlPullParse library and parse the data to Feedentry class.
3. FeedEntry
	- This class is used by ParseApplication to parse each feeds in this array of feeds.
	- Class with not much things to do. Its represent each feeds or each element from the list.
	- Contain only getter and setter plus on toString for display.
4. FeedAdepter
	- Custom adepter build to inflate the list with each feeds create from parseApplicaiton.
	- also contain implementation of view to recycle so that applicaiton will not use much of the memory from phone. 

### Screenshot
![Image of app screen](https://github.com/TenNga/TopDownload/blob/master/Screenshot_20190401-134408_Top%2010%20Downloader.jpg)
