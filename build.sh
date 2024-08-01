#!/bin/bash

# Define variables
BUILD_DIR="build"
OUTPUT_DIR="$BUILD_DIR/output"
JAR_FILE="EasyHR-Approval.jar"
MANIFEST_FILE="$BUILD_DIR/META-INF/MANIFEST.MF"

# Clean previous builds
echo "Cleaning previous builds..."
rm -rf $BUILD_DIR
mkdir -p $OUTPUT_DIR

# Compile the application
echo "Compiling the application..."
javac -d $BUILD_DIR src/main/java/HR/*.java

# Create a manifest file
echo "Creating manifest file..."
mkdir -p $BUILD_DIR/META-INF
echo "Main-Class: HR.Main" > $MANIFEST_FILE

# Package the application into a JAR file
echo "Packaging the application..."
jar cvfm $OUTPUT_DIR/$JAR_FILE $MANIFEST_FILE -C $BUILD_DIR .

# Run unit tests
echo "Running unit tests..."
mvn test

# Move the JAR file to output directory
echo "Build completed successfully. JAR file located at $OUTPUT_DIR/$JAR_FILE"