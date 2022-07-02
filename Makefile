default: versioncheck

versioncheck:
	./gradlew dependencyUpdates

upgrade-wrapper:
	./gradlew wrapper --gradle-version=7.5-rc-3 --distribution-type=bin