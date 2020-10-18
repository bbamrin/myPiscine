rm -rf target && \
wget -P lib https://repo1.maven.org/maven2/com/diogonunes/JColor/5.0.1/JColor-5.0.1.jar && \
wget -P lib https://repo1.maven.org/maven2/com/beust/jcommander/1.78/jcommander-1.78.jar && \
mkdir target && \
javac -cp lib/jcommander-1.78.jar:lib/JColor-5.0.1.jar -d target src/java/edu/school21/printer/*/*.java &&\
cp -r src/resources target/ &&\
jar xf lib/JColor-5.0.1.jar com &&\
jar xf lib/jcommander-1.78.jar com &&\
mv com target &&\
jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target/ . &&\
java -jar target/images-to-chars-printer.jar -w=RED -b=GREEN
#to use program next time just type java -jar target/images-to-chars-printer.jar

