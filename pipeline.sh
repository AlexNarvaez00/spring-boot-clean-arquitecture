#!/bin/bash -x
#USO: ./pipeline.sh --Name NombreModule --name nombre_modulo

# Obtenemos los parametros de la ejecucion del script 
Name=${2}
name=${4}

#Listamos los archivos de carpeta "templates"
templates=$(ls src/main/java/mx/edu/itoaxaca/templates/*/*.mustache)

#Iteramos en los archivos extraidos
for template in $templates
do
    NameToRemplace="{{Name}}"
    nameToRemplace="{{name}}"
    
    baseContentFile=$(cat $template) 
    
    newFileName="${template//templates/api\/v1\/$name}"
    newFileName="${newFileName//$NameToRemplace/$Name}"
    newFileName="${newFileName//mustache/java}"

    NameReplacementInBaseContentFile="${baseContentFile//$NameToRemplace/$Name}" 
    nameReplacementInBaseContentFile="${NameReplacementInBaseContentFile//$nameToRemplace/$name}" 

    echo "$newFileName"

    #mkdir -p -- "$(dirname -- "$newFileName")"
    #touch -- "$newFileName"
    #echo "$nameReplacementInBaseContentFile" >> "$newFileName" 
done