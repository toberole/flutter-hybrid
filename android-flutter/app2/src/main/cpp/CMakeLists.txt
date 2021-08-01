cmake_minimum_required(VERSION 3.10.2)

project("android_flutter-app2")

include_directories(${CMAKE_CURRENT_LIST_DIR})

aux_source_directory(${CMAKE_CURRENT_LIST_DIR} SRC_FILES)

add_library(app2-lib SHARED ${SRC_FILES})

find_library(
        log-lib
        log)

target_link_libraries(
        app2-lib
        ${log-lib})