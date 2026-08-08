# Week 12 Reflection — Bonus Feature Sprint (Week 2 of 2, Final)

*Second and last week of bonus feature work. Week 13 has no build time — this is the last chance to get your feature demo-ready before Week 14. This template replaces the standard weekly reflection, same as last week.*

**Name:*Samba Kamara*
**Date:*08/07/2026*
**My assigned bonus feature:** *Priorities*

---

## Commits This Week

**Link:*https://github.com/fascineh1/media-tracker-android/pull/12*

---

## Code Review

**Reviewed:** *Issa Ali*
**Link to my review:*https://github.com/Issa-Ismail-Ali/media-tracker-android/pull/11/changes#r3736843480*

### What I Looked At
--> I reviewed Issa's Week 12 implementation of the Quotes feature. 
I focused on how he finalized the networking layer by wiring the Retrofit endpoints, 
updating the repository, adding request models, and integrating the feature into the application's architecture.

### What I Noticed
--> I noticed that the networking layer was well organized. 
Issa separated the API models, Retrofit service, and repository logic, which keeps the UI independent of the networking code. 
I also noticed that error handling was centralized in the repository, making the implementation easier to maintain.

### Comments I Left
--> I commented that keeping the Retrofit API calls inside the repository instead of the UI layer makes the Quotes feature easier to maintain and test. 
I also noted that separating the request models, Retrofit service, and repository responsibilities keeps the networking implementation consistent with the rest of the application's architecture. 
Centralizing the error handling in the repository was another positive design choice because the UI does not need to duplicate API error-handling logic.
---

## Bonus Feature — Final Status before Week 14? 

**What works end-to-end, right now:**

--> The Priorities feature is complete and demo-ready. Users can add up to five Want To items as priorities, assign priority levels, estimated time, and notes, edit or remove priorities, and reorder them. 
The priority list is persisted through the API and displayed in order. 
The client-side five-item limit is enforced before an additional item can be added.

**Tests written for this feature:**

--> I added tests for priority reordering, orderIndex updates, the five-item maximum, prevention of a sixth priority, and rollback behavior when saving a reordered list fails.
All six unit tests pass.

**Known gaps or rough edges going into demos:**

--> The required functionality is complete. 
Remaining issues are limited to minor UI polish and do not block the feature.
---

## One Thing I Understood More Deeply

--> Across the two-week sprint, I understood more deeply how UI state, the ViewModel, and repository persistence need to work together when building a complete feature. 
The drag-and-drop reordering made this especially clear. When movePriority() changes the order, the ViewModel immediately updates the list and recalculates each item's orderIndex, then sends the updated list to the repository. 
This makes the UI feel responsive, but it also means the ViewModel needs to preserve the previous state in case the API request fails. If saving fails, the previous priority order is restored instead of leaving the UI showing an order that was never persisted. 
Building the feature from start to finish helped me understand that a feature is not complete just because the UI works; the UI state, API persistence, error handling, and tests all have to agree.
---

## One Thing I'm Still Confused About
--> I am still learning the best way to handle more complex gestures in Jetpack Compose.
The drag-and-drop implementation showed me that a gesture inside a scrollable container can compete with the scrolling behavior of the parent.
I was able to get the priority reordering working, 
but I would like to better understand Compose pointer input and gesture consumption so that I can implement drag-and-drop behavior more naturally in future applications
---

## Anything Else *(optional)*

<!-- Anything about the bonus feature sprint as a whole — the two-week format, being assigned a
     feature rather than choosing it, whatever's on your mind — is fair game here. -->

---

## Rubric

*You don't need to self-assess — this is here so you know what I'm looking at.*

| Section | Points | Full Credit | Half Credit | No Credit |
|:---|:---:|:---|:---|:---|
| **Reflection** | 10 | Honest final-status report — what works end-to-end, what's rough, what's tested — plus a specific, genuine "Understood More Deeply" that reflects on the sprint as a whole, not just this week. | Present but vague, or only reports on this week rather than the feature's overall state. | Missing or one-word answers. |
| **Code Review** | 10 | Specific observation about the code with explanation of why it matters (or a substantive positive comment). Link to review present and verified. | A question or comment that shows you read the code, but lacks explanation. | "Looks good!" or equivalent. Missing link. Review not found on GitHub. |
| **Total** | **20** | | | |

**A note on the code review score:** same as every other week — I check the link before grading.
