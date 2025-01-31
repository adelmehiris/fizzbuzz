# Utiliser une image légère de Java 21
FROM eclipse-temurin:21-jdk-jammy

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier jar généré depuis le dossier target
COPY target/fizzbuzz.jar app.jar

# Exposer le port par défaut (Render gère automatiquement les ports dynamiques)
EXPOSE 8080

# Démarrer l'application avec le profil prod
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]
