package com.pynexia.week3.quiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import java.util.List;
public final class MainActivity extends ComponentActivity {
 private List<QuizQuestion> questions; private int index=0,score=0,selected=-1; private TextView progress,timer,question,feedback; private Button[] choices; private Button next; private CountDownTimer countdown;
 @Override protected void onCreate(Bundle state){super.onCreate(state);setContentView(R.layout.activity_main);questions=QuizQuestion.all();progress=findViewById(R.id.progress);timer=findViewById(R.id.timer);question=findViewById(R.id.question);feedback=findViewById(R.id.feedback);choices=new Button[]{findViewById(R.id.answer0),findViewById(R.id.answer1),findViewById(R.id.answer2),findViewById(R.id.answer3)};next=findViewById(R.id.next);for(int i=0;i<choices.length;i++){final int choice=i;choices[i].setOnClickListener(v->choose(choice));}next.setOnClickListener(v->{if(index<questions.size())advance();else restart();});if(state!=null){index=state.getInt("index");score=state.getInt("score");selected=state.getInt("selected",-1);}if(index>=questions.size())finishQuiz();else showQuestion();}
 private void showQuestion(){QuizQuestion q=questions.get(index);selected=-1;progress.setText("QUESTION  "+(index+1)+" / "+questions.size()+"     SCORE  "+score);question.setText(q.prompt);feedback.setText("Choose the best answer.");for(int i=0;i<choices.length;i++){choices[i].setText(q.answers.get(i));choices[i].setEnabled(true);}next.setText("Continue");startTimer();}
 private void startTimer(){if(countdown!=null)countdown.cancel();countdown=new CountDownTimer(15000,1000){public void onTick(long left){timer.setText((left/1000)+"s");}public void onFinish(){timer.setText("0s");if(selected<0){selected=questions.get(index).correct;feedback.setText("Time is up. "+questions.get(index).explanation);lockChoices();}}}.start();}
 private void choose(int answer){if(selected>=0||index>=questions.size())return;selected=answer;if(countdown!=null)countdown.cancel();QuizQuestion q=questions.get(index);if(answer==q.correct){score++;feedback.setText("Correct. "+q.explanation);}else feedback.setText("Not quite. "+q.explanation);lockChoices();}
 private void lockChoices(){for(Button choice:choices)choice.setEnabled(false);}
 private void advance(){if(selected<0){feedback.setText("Choose an answer before continuing.");return;}if(countdown!=null)countdown.cancel();index++;if(index>=questions.size())finishQuiz();else showQuestion();}
 private void finishQuiz(){if(countdown!=null)countdown.cancel();progress.setText("QUIZ COMPLETE  ·  "+questions.size()+" QUESTIONS");timer.setText("Done");question.setText("You scored "+score+" / "+questions.size());feedback.setText(score>=8?"Excellent work — you have a strong start with APIs and JSON.":score>=5?"Good progress. Review the explanations and give it another round.":"Keep practicing. Each answer includes a quick explanation.");for(Button choice:choices)choice.setVisibility(android.view.View.GONE);next.setText("Play again");}
 private void restart(){index=0;score=0;for(Button choice:choices)choice.setVisibility(android.view.View.VISIBLE);showQuestion();}
 @Override protected void onSaveInstanceState(Bundle out){out.putInt("index",index);out.putInt("score",score);out.putInt("selected",selected);super.onSaveInstanceState(out);}
 @Override protected void onDestroy(){if(countdown!=null)countdown.cancel();super.onDestroy();}
}
