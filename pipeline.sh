#!/bin/bash -x
#USO: ./pipeline.sh --Name NombreModule --name nombre_modulo

# Comandos 
##----------------------------------------------------------------------

# bash pipeline.sh --module --Name NombreModule --name nombre_modulo
# bash pipeline.sh --atribute --Name NombreAttributo --module-name nombre_modulo
# bash pipeline.sh --test --Name NombreModulo --module-name nombre_modulo

##----------------------------------------------------------------------

commandName=${1}

if [[ "$commandName" =~ "--module"  ]]; then
    # Obtenemos los parametros de la ejecucion del script 
    Name=${3}
    name=${5}

    #Listamos los archivos de carpeta "templates"
    templates=$(ls src/main/java/mx/edu/itoaxaca/templates/module/*/*.mustache)
    templates2=$(ls src/main/java/mx/edu/itoaxaca/templates/module/*/*/*.mustache)

    #Declaramos una funcion 
    createFilesToModule () {
        Name=$1
        name=$2
        templates=$3
        #Iteramos en los archivos extraidos
        for template in $templates
        do
            NameToRemplace="{{Name}}"
            nameToRemplace="{{name}}"
            
            baseContentFile=$(cat $template) 
            
            newFileName="${template//templates/api\/v1\/$name}"
            newFileName="${newFileName//$NameToRemplace/$Name}"
            newFileName="${newFileName//mustache/java}"
            newFileName="${newFileName//\/module/}"

            NameReplacementInBaseContentFile="${baseContentFile//$NameToRemplace/$Name}" 
            nameReplacementInBaseContentFile="${NameReplacementInBaseContentFile//$nameToRemplace/$name}" 

            #echo "$newFileName"
            mkdir -p -- "$(dirname -- "$newFileName")"
            touch -- "$newFileName"
            echo "$nameReplacementInBaseContentFile" >> "$newFileName" 
        done
    }

    createFilesToModule "$Name" "$name" "$templates"
    createFilesToModule "$Name" "$name" "$templates2"
fi

if [[ "$commandName" =~ "--attribute" ]]; then
    NameAttribute=${2} 
    nameModuele=${4} 
    
    templates=$(ls src/main/java/mx/edu/itoaxaca/templates/module/domain/{{Name}}Name*.mustache)
    for template in $templates
    do
        NameToRemplace="{{Name}}"
        nameToRemplace="{{name}}"
    
        baseContentFile=$(cat $template) 
        newFileName="${template//templates/api\/v1\/$nameModuele}"
        newFileName="${newFileName//$NameToRemplace/$NameAttribute}"
        newFileName="${newFileName//mustache/java}"
        newFileName="${newFileName//\/module/}"

        NameReplacementInBaseContentFile="${baseContentFile//$NameToRemplace/$NameAttribute}" 
        nameReplacementInBaseContentFile="${NameReplacementInBaseContentFile//$nameToRemplace/$nameModuele}" 
        nameReplacementInBaseContentFile="${nameReplacementInBaseContentFile//Name/}" 
        
        #echo "$newFileName"
        #mkdir -p -- "$(dirname -- "$newFileName")"
        touch -- "$newFileName"
        echo "$nameReplacementInBaseContentFile" >> "$newFileName"
    done
fi

if [[ "$commandName" =~ "--test"  ]]; then
    # Obtenemos los parametros de la ejecucion del script 
    Name=${3}
    name=${5}

    #Listamos los archivos de carpeta "templates"
    templates=$(ls src/main/java/mx/edu/itoaxaca/templates/test/*/*.mustache)
    templates2=$(ls src/main/java/mx/edu/itoaxaca/templates/test/*/*/*.mustache)

    #Declaramos una funcion 
    createFilesToModule () {
        Name=$1
        name=$2
        templates=$3
        #Iteramos en los archivos extraidos
        for template in $templates
        do
            NameToRemplace="{{Name}}"
            nameToRemplace="{{name}}"
            
            baseContentFile=$(cat $template) 
            
            newFileName="${template//templates/api\/v1\/$name}"
            newFileName="${newFileName//$NameToRemplace/$Name}"
            newFileName="${newFileName//mustache/java}"
            newFileName="${newFileName//\/test/}"
            newFileName="${newFileName//\/main/\/test}"

            NameReplacementInBaseContentFile="${baseContentFile//$NameToRemplace/$Name}" 
            nameReplacementInBaseContentFile="${NameReplacementInBaseContentFile//$nameToRemplace/$name}" 

            #echo "$newFileName"
            mkdir -p -- "$(dirname -- "$newFileName")"
            touch -- "$newFileName"
            echo "$nameReplacementInBaseContentFile" >> "$newFileName" 
        done
    }

    createFilesToModule "$Name" "$name" "$templates"
    createFilesToModule "$Name" "$name" "$templates2"
fi




