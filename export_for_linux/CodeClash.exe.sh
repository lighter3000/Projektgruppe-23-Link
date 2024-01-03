#!/bin/sh
echo -ne '\033c\033]0;Project_CodeClash\a'
base_path="$(dirname "$(realpath "$0")")"
"$base_path/CodeClash.exe.x86_64" "$@"
