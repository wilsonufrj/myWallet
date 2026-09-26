# Repository Guidelines

## Project Structure & Module Organization

This repository contains two applications. `backEnd/` is a Java 17 Spring Boot service; production code lives under `src/main/java/br/projeto/mywallet`, grouped into `Controller`, `Service`, `ServiceImpl`, `repository`, `Model`, `DTO`, and `Mappers`. Runtime profiles and Flyway migrations are in `backEnd/src/main/resources`; backend tests mirror the package tree under `src/test/java`.

`frontEnd/mywallet/` is a React 17 TypeScript application. Page-level features are under `src/pages`, shared UI under `src/components`, Redux setup under `src/redux`, and domain types under `src/Domain`. Static browser assets belong in `public/`; imported images belong in `src/Images`.

## Build, Test, and Development Commands

- `cd backEnd && mvn spring-boot:run` starts the API using the active Spring profile.
- `cd backEnd && mvn test` runs the JUnit 5/Mockito test suite.
- `cd backEnd && mvn clean package` builds and verifies the backend JAR.
- `cd frontEnd/mywallet && npm ci` installs the locked frontend dependencies.
- `npm start` starts the React development server at `http://localhost:3000`.
- `npm test -- --watchAll=false` runs frontend tests once; `npm run build` creates a production bundle.

Run commands from the module directory shown. The backend expects PostgreSQL and applies migrations from `db/migration`.

## Coding Style & Naming Conventions

Follow the existing formatting: four-space indentation in Java and two spaces in TypeScript/TSX. Use PascalCase for Java classes, React components, and domain types; use camelCase for methods, variables, hooks, and Redux slice files. Backend interfaces use the existing `INameService`/`INameRepository` pattern. Keep controllers thin, business rules in services, persistence in repositories, and entity/DTO conversion in MapStruct mappers. Frontend linting uses the Create React App ESLint configuration.

## Testing Guidelines

Name backend test files `*Test.java` and test methods after behavior, such as `buscarBancoPorId_QuandoNaoExistir_DeveLancarExcecao`. Mock repository boundaries with Mockito and cover success, validation, and not-found paths. Place React tests beside the component as `*.test.tsx`. No coverage threshold is configured; add regression tests for every bug fix.

## Commit & Pull Request Guidelines

Recent history uses short prefixes such as `feat:`, `hotfix:`, `refactor:`, and `doc:`. Use `<type>: <imperative summary>` and keep each commit focused. Pull requests should explain the change and validation performed, link related issues, call out database migrations or profile changes, and include screenshots for visible UI changes. Never commit real credentials; keep environment-specific database values out of shared properties files.
