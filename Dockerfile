# Utiliser Java 21
FROM eclipse-temurin:21-jdk-jammy

# Définir le répertoire de travail
WORKDIR /app

# Copier le projet dans l'image Docker
COPY . .

# Donner les permissions d'exécution au script mvnw
RUN chmod +x ./mvnw

# Construire le fichier .jar
RUN ./mvnw clean package -DskipTests

# Copier le fichier généré vers app.jar
RUN cp target/*.jar app.jar

# Exposer le port
EXPOSE 8080

# Lancer l'application avec le profil prod
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]
