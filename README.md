# AndroidStarterArchitecture
A approach to start a new Android app with architecture

# Clean Architecture Android Starter Template

## Quick Guide

Hello, my name is Bruno. This repository contains the Android Kotlin Starter, a project created to serve as a solid and realistic starting point for Android applications.

After researching and testing different architectural approaches over the years, I put this template together to better reflect how I like to structure real projects. The focus here is not novelty, but clarity, separation of concerns, and long-term maintainability**.

This starter is intended to be useful both for learning and for real production work. It is the kind of base project I would want to reuse and evolve over time.

---

## Technologies Used

* Kotlin
* Hilt (Dependency Injection)
* Retrofit (Networking)
* Room (Local persistence)
* Coroutines
* ViewModel
* Clean Architecture principles

---

## Project Folder Structure


app/            UI layer, DI, and navigation
 ├─ di/          Dependency Injection (Hilt modules)
 ├─ navigation/  Navigation graph and routes
 └─ ui/          Screens and UI components

core/           Shared core logic
 ├─ database/    Room database, DAOs, entities
 ├─ network/     Retrofit setup and API services
 ├─ utils/       Utility classes
 └─ model/       Base/shared models

data/           Data layer implementations
 ├─ repository/  Repository implementations
 ├─ remote/      Remote data sources (API, DTOs)
 └─ local/       Local data sources (Room)

domain/         Business rules (pure Kotlin)
 ├─ model/       Domain models
 ├─ repository/  Repository contracts
 └─ usecase/     Application use cases


---

## Folder Responsibilities

* app/di: Hilt modules and dependency bindings
* app/navigation: Navigation setup and destinations
* app/ui/components: Reusable UI components
* core/database: Room configuration and DAOs
* core/network: Retrofit configuration and services
* data/remote: API calls and DTO mapping
* data/local: Local persistence implementations
* domain/usecase: Business logic
* domain/repository: Interfaces that abstract data sources

---

## Creating a New Feature

Suggested structure for a new feature:


ui/featureName/
 ├─ FeatureFragment.kt
 ├─ FeatureViewModel.kt
 └─ FeatureUiState.kt

domain/
 ├─ usecase/
 ├─ model/
 └─ repository/

data/
 ├─ repository/
 ├─ remote/
 └─ local/


The intention is to keep UI, business logic, and data access clearly separated, making the codebase easier to test and evolve.

---

## Running the Project

1. Open the project in Android Studio
2. Wait for Gradle sync to finish
3. Run on an emulator or physical device
4. Execute available unit or instrumented tests

---

## Architectural Notes

This project follows a classic Clean Architecture approach:

* The UI layer depends on the domain layer
* The domain layer is independent of frameworks
* The data layer implements domain contracts

This structure aims to reduce coupling and make refactoring less risky as the project grows.

---

## Notes

This template is meant to be adapted. Folder boundaries, naming, and patterns can be adjusted depending on the needs of the project.


