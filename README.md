# CMSC434Doodle
My Doodle App

I used a color picker from 'com.pes.materialcolorpicker:library:1.0.+' in my DoodleApp project. It allows a button click to open a dialog at which the user can select red, blue, and green inputs and change the color.

To run the app, the most important thing is to add the "compile 'com.pes.materialcolorpicker:library:1.0.+' " line to the build.gradle file under the dependencies. This will allow the code to use the ColorPicker.

Otherwise, it's pretty straightforward. Just put the two Java classes inside the project and add the layout file to the res/layout folder. Also, put the strings.xml file in the res/values folder. Then you should be good to build and run.

Inside the app, opacity, color, and brush size can be changed, as per the specifications. My added feature is a "Quad draw" method, which allows input to be drawn in all four quadrants of the canvas. This allows for some cool flower-type shapes to be drawn.
