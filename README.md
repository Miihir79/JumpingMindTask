# JumpingMindTask

<p>

<img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white"/>  
<img src="https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white"/>

[![JumpingMindTask App](https://img.shields.io/badge/JumpingMind✅-APK-red.svg?style=for-the-badge&logo=android)](https://github.com/Miihir79/JumpingMindTask/releases/download/1.0.0/app-debug.apk)

</p>

This app was build on top of api provided by <a href="https://punkapi.com/">Punk API</a>, it displays list of beers and shows it details, you can even save these beers for future use.

### Screenshots
<table>
  <tr>
    <td>List of Beers <img src="https://user-images.githubusercontent.com/66465511/214590013-2c048fe8-f227-456b-9ddd-8a48d6478c42.jpg" width="250">
    <td>Liked Beers <img src="https://user-images.githubusercontent.com/66465511/214590027-ad0415e0-5c5b-4cdb-9995-96d0cc3800c3.jpg" width="250">
    <td>Beer Details <img src="https://user-images.githubusercontent.com/66465511/214590032-3c9ae45c-8927-4561-9799-fea236015537.jpg" width="250">
  <tr>
</table>


### Salient features of the app

  - Api request Paged using Paging library
  - User made accustomed to the app using prompts
  - Liked Beers stored in local RoomDB
  - Implemented Databinding
  - Animations and transitions
  - Shimmer effect for loading images
  - R8 optimization
  
  
### Demo

https://user-images.githubusercontent.com/66465511/214589829-b3a2e05f-f4cc-40c3-869a-dc88fbed31b4.mp4



### Libraries used
  - Gson 
  - Intuit sdp & ssp
  - Retrofit
  - shredpreferences
  - Glide
  - Room
  - Paging
  - Shimmerview
  - material tap target prompt
  - Splashscreen API
  
### ***Download the app from here👇***
  
[![JumpingMindTask App](https://img.shields.io/badge/JumpingMind✅-APK-red.svg?style=for-the-badge&logo=android)](https://github.com/Miihir79/JumpingMindTask/releases/download/1.0.0/app-debug.apk)

## Package Structure

    com.mihir.jumpingmindtask    # Root Package
    .
    ├── model                # Model data classes
    |
    ├── database             # RoomDB and TypeConverters
    |
    ├── network              # AppObjectController, Retrofit, network service
    |
    ├──  ui                  # UI/View layer
    |    ├── adapter         # Adapter, ViewHolder
    |    └── screens         # Activity, Fragments
    |
    └── viewmodel            # ViewModels
  
  
## How to contribute?
### What do you need to get started?
#### Latest version of android studio and basic android and googling skills will get you going.
All contributions are welcomed, Properly describe changes made and attach supporting ScreenShots in the PR. For major changes first open an issue.

## Author
Initial work: <a href="https://github.com/Miihir79">***Mihir Shah***</a> <br>
This project was created as an interview process assignment. <br>
Obtained the beer icon from <a href="https://www.uplabs.com/posts/beer-app-icon">here</a> and the due credit goes to the creator.
