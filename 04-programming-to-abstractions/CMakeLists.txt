cmake_minimum_required(VERSION 3.20)

project(programming_to_abstractions_c_examples LANGUAGES C)

set(CMAKE_C_STANDARD 11)
set(CMAKE_C_STANDARD_REQUIRED ON)
set(CMAKE_C_EXTENSIONS OFF)

file(GLOB module_c_sources CONFIGURE_DEPENDS
  "${CMAKE_CURRENT_SOURCE_DIR}/src/main/c/*.c"
)

if(NOT module_c_sources)
  message(
    WARNING
    "No standalone C examples were found in src/main/c."
  )
endif()

foreach(source_file IN LISTS module_c_sources)
  get_filename_component(target_name "${source_file}" NAME_WE)
  add_executable("${target_name}" "${source_file}")
  target_compile_options("${target_name}" PRIVATE
    $<$<C_COMPILER_ID:GNU,Clang>:-Wall -Wextra -pedantic>
    $<$<C_COMPILER_ID:MSVC>:/W4>
  )
endforeach()
