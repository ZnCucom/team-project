# Lo-Fi Companion

[English](README.md) | [中文](README.zh-CN.md)

## Project Description

Lo-Fi Companion is a Java Swing desktop application designed to create a relaxing and supportive environment for studying or working.

The application combines several connected features:

- focus and task management,
- a virtual pet,
- Spotify-based background music,
- and weather-based scenery.

The goal of the project is to create a small virtual study space where users can plan what they need to do, focus on their work, listen to music, and receive simple companionship from a virtual pet.

Our initial version will support one user, one pet, a lightweight task list, a focus timer, a small set of dialogue messages, Spotify integration where available, weather-based scenery, and a single main application window.

---

## Core User Stories

### 1. Focus Timer and To-Do List
**Owner: [Member A]**

As a student, I want to manage tasks and use a focus timer so that I can organize what I need to do and track my study progress.

The initial version will include:

- a focus timer with configurable duration,
- start, pause, resume, and reset controls,
- completed focus-session tracking,
- and a lightweight to-do list for managing study tasks.

The exact design of the to-do list will be refined later. Possible first-version actions include adding tasks, marking tasks as completed, and removing tasks.

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

The pet may also react when the user completes a focus session or finishes a task.

---

### 3. Spotify Music Integration
**Owner: [Member C]**

As a user, I want to connect Spotify and control my study music from the application so that I can create a comfortable study atmosphere without leaving my workspace.

The planned Spotify integration may allow users to:

- connect a Spotify account,
- view the currently playing track,
- access selected music or playlists,
- control supported playback actions such as play, pause, skip, and volume,
- and restore relevant music preferences when the application is reopened.

The exact Spotify functionality will depend on the capabilities, authentication requirements, and access restrictions of the Spotify Web API.

If Spotify is unavailable or cannot be connected, the rest of the application should remain usable. A simple fallback music option may be added if necessary.

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

Each team member will be primarily responsible for one complete area of the application, including its user interface, application logic, Clean Architecture components, and related tests.

| Team Member | Primary Area | Main Responsibilities |
| --- | --- | --- |
| [Member A] | Focus & Task Management | Focus timer, completed-session tracking, to-do list, related UI, and tests |
| [Member B] | Pet Interaction | Pet state, friendship progression, dialogue system, pet UI, and tests |
| [Member C] | Spotify Music Integration | Spotify authentication/integration, playback controls, music state/preferences, related UI, and tests |
| [Member D] | Weather-Based Scenery | Weather API integration, weather-to-scene mapping, weather UI, error handling, and tests |

Shared application components, integration work, and overall design decisions will be discussed and reviewed by the entire team.

---

## Feature Integration

The features are intended to work together rather than behave as four independent mini-applications.

For example:

- completing a focus session may increase pet friendship and trigger an encouraging dialogue,
- completing a task may trigger a short pet response,
- the weather system may change the room background,
- and Spotify music can continue playing while the user works with the timer or task list.

The first version will keep these interactions simple so that each use case remains manageable.

---

## Data Persistence

The application will store relevant user data locally using JSON.

The saved data may include:

- the pet's name,
- friendship progress,
- completed focus sessions,
- to-do list data,
- music preferences or Spotify-related settings that are appropriate to store,
- volume preferences,
- and the selected city.

This information will be restored when the application is reopened.

Sensitive authentication credentials or secrets will not be stored directly in the project repository.

---

## Planned External APIs

### Spotify Web API

The music feature plans to use the Spotify Web API.

The integration may be used to retrieve Spotify information and control supported playback features after the user authorizes the application.

Spotify-specific code will be separated from the main application logic through interfaces so that API-related changes do not require major changes to the rest of the application.

Because Spotify access depends on authentication, account capabilities, and API restrictions, the exact supported music controls will be confirmed during implementation.

### Weather API

The weather feature will use an external weather service to retrieve current weather information for a selected city.

The exact weather API provider has not yet been finalized.

The weather functionality will also be separated from the main application logic through an interface so that the provider can be replaced without significantly affecting the rest of the application.

If weather data cannot be retrieved, the application will use a default scene.

---

## Initial Scope

The first version of Lo-Fi Companion is planned to include:

- one Java Swing application window,
- one virtual pet,
- a simple friendship system,
- basic pet dialogue,
- a focus timer,
- completed focus-session tracking,
- a lightweight to-do list,
- Spotify integration with a limited set of supported music controls,
- current weather retrieval,
- several weather-based room scenes,
- and local JSON persistence.

The project will prioritize a small but complete and reliable application over a large number of features.

---

## Features Outside the Initial Scope

The following features are not currently planned for the first version:

- multiplayer support,
- user accounts for the Lo-Fi Companion application itself,
- cloud synchronization,
- multiple pets,
- complex story branching,
- advanced task-management features,
- advanced Spotify library management,
- advanced desktop-overlay behaviour,
- and AI-generated dialogue.

These features may be considered only if the core application is completed first.
