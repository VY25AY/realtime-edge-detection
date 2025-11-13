cmake_minimum_required(VERSION 3.10.2)
project("native-lib")

# OpenCV SDK path - will be set from Gradle build configuration
# Alternative: Can be set via environment variable OPENCV_DIR
# Download OpenCV Android SDK from: https://opencv.org/releases/

# Try to use OpenCV_DIR from Gradle arguments first, then fallback to relative path
if(NOT DEFINED OpenCV_DIR)
    set(OpenCV_DIR ${CMAKE_SOURCE_DIR}/../../../opencv/sdk/native/jni)
endif()

message(STATUS "Looking for OpenCV in: ${OpenCV_DIR}")

find_package(OpenCV REQUIRED)

if(OpenCV_FOUND)
    message(STATUS "OpenCV ${OpenCV_VERSION} found successfully!")
    message(STATUS "OpenCV libs: ${OpenCV_LIBS}")
else()
    message(FATAL_ERROR "OpenCV not found! Please check OpenCV_DIR path.")
endif()

add_library(native-lib SHARED native-lib.cpp)

include_directories(${OpenCV_INCLUDE_DIRS})

target_link_libraries(native-lib
    ${OpenCV_LIBS}
    log
    android
)

