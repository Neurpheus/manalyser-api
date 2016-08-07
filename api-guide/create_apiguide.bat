@echo off
REM ----------------------------------------
REM Run API Guide Doclet on the itself.  
REM ----------------------------------------   
rem  -links_in_summary_tables ^
rem  -chapter_navigation_links ^
rem  -class_section_navigation_links ^
rem   -subpackages "org.neurpheus.nlp.morphology" ^
rem  org.neurpheus.nlp.morphology org.neurpheus.nlp.morphology.tagset^


java -showversion -mx48m -ms24m ^
  -classpath "ApiGuideDoclet.jar;./taglet;%JAVA_HOME%/lib/tools.jar" ^
  "apiguide.ApiGuideDoclet" ^
  ^
  org.neurpheus.nlp.morphology org.neurpheus.nlp.morphology.tagset ^
  -doclet apiguide.ApiGuideDoclet ^
  -sourcepath "..\src\main\java" ^
  -d ./doc/morphology-api-guide.html ^
  -copy_doc_files ^
  -delete_doc_files ^
  -use_combined_package_classes_table ^
  -use_combined_package_contents_list ^
  -no_generated_constructors ^
  -links_in_summary_tables ^
  -sort_class_members ^
  -api_title "Neurpheus Morphological Components" ^
  -overview "..\overview.html" ^
  -body_start_html_file "html-files/apiguide_body_start.html" ^
  -overview_end_html_file "html-files/apiguide_overview_end.html" ^
  -taglet AlertTaglet ^
  -taglet NoteTaglet ^
  -tag "param^Parameters:^termlist" ^
  -tag "exception^Throws:^termlist" ^
  -tag "return^Returns:" ^
  -tag since ^
  -tag "see^See Also:" ^
  -write_concordance_file

  
 pause 