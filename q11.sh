for i in $(find . -type f -name "*.c")
do 
    file_name=`echo $i | cut -d'/' -f2`
    prog_name=`echo $file_name | cut -d'.' -f1`
    gcc $file_name -o $prog_name 2>/dev/null
    
    if [ -f "$prog_name" ]   
    then
        ans=$(./$prog_name)
        if [ $ans = "20" ]
        then
            printf "%s\t%s\n" $file_name "10"
        else 
            printf "%s\t%s\n" $file_name "7"
        fi
    else
        printf "%s\t%s\n" $file_name "5"
    fi
done
exit 0