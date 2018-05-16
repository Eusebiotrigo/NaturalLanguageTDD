Skeleton to do a TDD exercise.

The endpoint /api/time will return the current time in natural language format.

The objective is not to build a robot or an IA, but by using TDD make the code reply more and more complex time combinations.

Examples:
16:20 should return "Twenty past four"
17:00 should return "Five o'clock"

But... feel free to return "Tea time", "Midnight", "Noon"...

Controller:
TimeToNaturalLanguageController - exposes the /api/time endpoint.

Services:
TimeService - returns the current LocalTime.
TimeToNaturalLanguageService - Service used to translate the current LocalTime into natural language.
