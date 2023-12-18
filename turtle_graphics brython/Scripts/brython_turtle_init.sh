#!/bin/bash

# GitHub Repository URL
repository_url="https://github.com/noahsbl/Learn-Python-with-Turtle-Graphics.git"

# Target directory
target_directory="Learn-Python-with-Turtle-Graphics"

# Check if target directory exists
if [ ! -d "$target_directory" ]; then
    # Clone repository if it doesn't exist
    git clone $repository_url $target_directory
fi

# Change to the target directory
cd $target_directory

# Determine the available Python version
if command -v python3 &> /dev/null; then
    python_cmd="python3"
elif command -v python &> /dev/null; then
    python_cmd="python"
else
    echo "Error: Python 3 or Python is required but not found."
    exit 1
fi

# Print the link before starting the Python HTTP server
echo "Open the following link in your browser:"
echo "http://localhost:8000/code-editor.html"

# Start Python HTTP server (default port 8000)
$python_cmd -m http.server

# Optional:
# python -m http.server
