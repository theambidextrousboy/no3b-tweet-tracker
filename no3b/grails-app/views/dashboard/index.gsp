<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>no3b Oshimen Tracker</title>
        <meta content='main' name='layout' />
        <g:javascript library='jquery' />
        <r:layoutResources/>
        <g:javascript src='no3b/main.js' />
        <g:javascript src='no3b/popularity/popularity.js' />
    </head>

    <body>
        <div id='member-area'>
            <h2>no3b Popularity Tracker</h2>
            <div id='minegishi'>
                <label id='minegishi-name'>Minegishi Minami</label>
                <div id='minegishi-pic'></div>

                <input type='button' value='Who is loving me?' id='minegishi-popularity-button'>

                <div id="minegishi-message">
                    <label id="minegishi-text"></label>
                </div>
            </div>

            <div id='kojiharu'>
                <label id='kojiharu-name'>Kojima Haruna</label>
                <div id='kojiharu-pic'></div>

                <div id='kojiharu-buttons'>
                    <input type='button' value='Who is loving me?' id='kojiharu-popularity-button'>
                </div>

                <div id='kojiharu-message'>
                    <label id='kojiharu-text'></label>
                </div>
            </div>

            <div id='takamina'>
                <label id='takamina-name'>Takahashi Minami</label>
                <div id='takamina-pic'></div>

                <div id='takamina-buttons'>
                    <input type='button' value='Who is loving me?' id='takamina-popularity-button'>
                </div>

                <div id='takamina-message'>
                    <label id='takamina-text'></label>
                </div>
            </div>
        </div>

    </body>
</html>