# Lo-Fi Companion

## Project Description

Lo-Fi Companion is a Java Swing desktop application designed to create a relaxing and supportive environment for studying or working.

The application combines four main features:

- a focus timer,
- a virtual pet,
- background music,
- and weather-based scenery.

The goal of the project is to create a small virtual study space where users can focus on their work while receiving simple companionship from a virtual pet.

Our initial version will support one user, one pet, a small set of dialogue messages and music tracks, and a single main application window.

---

## Core User Stories

### 1. Focus Timer
**Owner: [Member A]**

As a student, I want to set, start, pause, resume, and reset a focus timer and review my completed focus sessions so that I can organize and track my study time.

The initial version will allow users to:

- choose a focus duration,
- start, pause, resume, and reset the timer,
- record completed focus sessions,
- and view the number of completed sessions.

Completing a focus session may also trigger a short encouraging response from the virtual pet.

---

### 2. Pet Interaction
**Owner: [Member B]**

As a user, I want to name and interact with my virtual pet and unlock new dialogue as our friendship grows so that I can feel a sense of companionship while studying.

The initial version will allow users to:

- give the pet a name,
- interact with the pet,
- increase friendship progress,
- and unlock different dialogue messages based on friendship progress.

The pet may also react when the user completes a focus session.

---

### 3. Background Music
**Owner: [Member C]**

As a user, I want to choose background music, control playback, and adjust the volume so that I can create a comfortable study atmosphere.

The initial version will allow users to:

- choose from a small collection of bundled music tracks,
- play and pause music,
- switch between tracks,
- adjust playback volume,
- and restore the user's previous music preferences when the application is reopened.

---

### 4. Weather-Based Scenery
**Owner: [Member D]**

As a user, I want to select a city and see the room scenery reflect its current weather so that my study environment feels connected to the outside world.

The initial version will allow users to:

- enter or select a city,
- retrieve the current weather using an external weather API,
- map the weather to a small number of scene types such as sunny, cloudy, rainy, or snowy,
- and display the corresponding room background.

If weather data cannot be retrieved, the application will display a default scene while allowing the other features to continue working normally.

---

## Feature Ownership

Each team member will be primarily responsible for one complete use case, including the user interface, application logic, Clean Architecture components, and tests associated with that feature.

| Team Member | Primary Feature | Main Responsibilities |
| --- | --- | --- |
| [Member A] | Focus Timer | Timer logic, focus-session tracking, timer UI, and related tests |
| [Member B] | Pet Interaction | Pet state, friendship progression, dialogue system, pet UI, and related tests |
| [Member C] | Background Music | Track selection, playback controls, volume control, music preferences, and related tests |
| [Member D] | Weather-Based Scenery | Weather API integration, weather-to-scene mapping, weather UI, error handling, and related tests |

Shared application components, integration work, and overall design decisions will be discussed and reviewed by the entire team.

---

## Data Persistence

The application will store user data locally using JSON.

The saved data may include:

- the pet's name,
- friendship progress,
- completed focus sessions,
- music preferences,
- volume settings,
- and the selected city.

This information will be restored when the application is reopened.

---

## External API

The weather feature will use an external weather service to retrieve current weather information for a selected city.

The exact API provider has not yet been finalized.

The weather functionality will be separated from the main application logic through an interface so that the external provider can be changed without significantly affecting the rest of the application.

If the external weather service is unavailable, the application will use a default scene.

---

## Initial Scope

The first version of Lo-Fi Companion will include:

- one Java Swing application window,
- one virtual pet,
- a simple friendship system,
- a focus timer,
- focus-session tracking,
- a small number of bundled music tracks,
- basic playback and volume controls,
- current weather retrieval,
- several weather-based room scenes,
- and local JSON persistence.

The project will prioritize a small but complete and reliable application over a large number of features.

---

## Features Outside the Initial Scope

The following features are not currently planned for the first version:

- multiplayer support,
- user accounts,
- cloud synchronization,
- multiple pets,
- complex story branching,
- streaming-service integration,
- advanced desktop-overlay behaviour,
- and AI-generated dialogue.

These features may be considered only if the core application is completed first.