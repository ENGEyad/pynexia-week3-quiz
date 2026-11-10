# Quiz App

A timed multiple-choice quiz about REST APIs, JSON, Android networking and image loading, with scoring and answer explanations.

Pynexia Android Development / Week 3.

[Hosted showcase](https://engeyad.github.io/pynexia-week3-quiz/) · [PDF report](https://github.com/ENGEyad/pynexia-week3-quiz/releases/latest/download/Quiz-App-Report.pdf) · [APK](https://github.com/ENGEyad/pynexia-week3-quiz/releases/latest/download/Quiz-App.apk) · [Source ZIP](https://github.com/ENGEyad/pynexia-week3-quiz/releases/latest/download/Quiz-App.zip)

## Implementation

### Interactive quiz

Ten four-option questions are presented one at a time with an answer selection and continue flow.

### Timer and score

Each question has a 15-second countdown. The score updates after correct answers; a timed-out answer does not earn a point.

### Feedback and restart

Each answer explains the concept. The end screen reports the score and offers another round.

## Build

JDK 17/21, Android SDK 35, Android 8.0/API 26 or newer. Initial dependency sync requires internet.

```powershell
.\gradlew.bat :quiz:assembleDebug :quiz:lintDebug
```

## Walkthrough

1. Read the question and choose one of four answers.
2. Answer before the 15-second timer ends.
3. Review the explanation and continue through all ten questions.
4. See the final score and choose Play again.

## Verification

Debug build passed. Automated tests were not run. Lint reported 0 errors and 31 warnings; see `verification/`. Pixel 8 emulator, Android 17/API 37. No physical-device or API 26 review.

## Scope

The quiz questions and answer key are bundled in the app. No internet connection is required. Scores are for the current round and are not saved as a long-term record.

## References

- https://developer.android.com/develop/connectivity/network-ops/connecting

The hosted page displays screenshots and downloads; it is not an Android emulator.
