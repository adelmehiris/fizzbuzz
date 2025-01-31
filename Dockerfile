# Utiliser Java 21
FROM eclipse-temurin:21-jdk-jammy

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier jar généré
COPY target/fizzbuzz.jar app.jar

# Exposer le port
EXPOSE 8080

# Lancer l'application
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]
