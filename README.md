# An older OOP project for creating ASCII art with filters.

## Running a program (for example):

Before running these examples, you need to start sbt in your terminal. After that, you can execute all of these commands in the sbt interactive mode:

    run --image img2.jpg --output-console --output-file tree_ascii_art.txt
    
    run --image img2.jpg --rotate -90 --flip x --brightness -150 --invert --output-console
    
    run --image img2.jpg --output-console --invert
    
    run --image img2.jpg --output-console --table bourke-small
    
    run --image img2.jpg --output-console --table bourke-large
    
    run --image img2.jpg --output-console --custom-table " #"

Alternatively, you can run any of these commands directly from your terminal using this syntax:
    
    sbt "run --image img2.jpg --output-console --output-file tree_ascii_art.txt"
