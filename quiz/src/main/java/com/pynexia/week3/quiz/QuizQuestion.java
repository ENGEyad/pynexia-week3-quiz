package com.pynexia.week3.quiz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public final class QuizQuestion {
 public final String prompt,explanation; public final List<String> answers; public final int correct;
 public QuizQuestion(String prompt,String explanation,int correct,String...answers){this.prompt=prompt;this.explanation=explanation;this.correct=correct;this.answers=Collections.unmodifiableList(Arrays.asList(answers));if(correct<0||correct>=answers.length||answers.length<2)throw new IllegalArgumentException("Question needs a valid answer.");}
 public static List<QuizQuestion> all(){return Arrays.asList(
  new QuizQuestion("Which HTTP method is used to retrieve data?","GET reads a resource from a server.",0,"GET","POST","PATCH","DELETE"),
  new QuizQuestion("What format does the Dictionary app parse?","The API response is structured as JSON.",1,"CSV","JSON","XML only","Plain image"),
  new QuizQuestion("Which library defines typed HTTP endpoints?","Retrofit maps service interfaces to HTTP requests.",2,"Glide","Gson only","Retrofit","RecyclerView"),
  new QuizQuestion("What does JSON stand for?","JSON means JavaScript Object Notation.",0,"JavaScript Object Notation","Java Source Object Name","Joined Server Output Network","Java Standard Object Node"),
  new QuizQuestion("Where should a slow network request run?","Asynchronous work keeps the main thread available for drawing and input.",2,"On the main thread","Inside onDraw","Asynchronously","Inside a layout XML"),
  new QuizQuestion("What commonly represents a JSON list?","JSON arrays contain ordered values.",1,"An XML tag","An array","An HTTP header","A color"),
  new QuizQuestion("What is an HTTP 404 response?","404 means that the requested resource was not found.",3,"Request accepted","Server is loading","No internet permission","Resource not found"),
  new QuizQuestion("What does Glide help an Android app do?","Glide loads and caches images for views.",0,"Load and cache images","Run SQL migrations","Schedule alarms","Parse XML layouts"),
  new QuizQuestion("Why show loading and error states?","They make asynchronous network progress and failures clear to users.",1,"To make every call synchronous","To communicate request progress and failures","To hide all results","To avoid JSON"),
  new QuizQuestion("What is a REST API response status 200?","HTTP 200 indicates a successful request.",2,"Authentication expired","Resource missing","Request succeeded","Server is offline"));}
}
