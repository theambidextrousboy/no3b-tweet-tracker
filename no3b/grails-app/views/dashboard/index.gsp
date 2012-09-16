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
            <h2>NO3B Popularity Tracker</h2>
            <div id='minegishi'>
                <div id='minegishi-pic'></div>
                <label for='minegishi-pic'>Minegishi Minami</label>

                <div id='minegishiButtons'>
                    <input type='button' value='Where am I Popular?' id='minegishi-popularity-button'>
                </div>

                <div id="minegishi-message">
                    <label id="minegishi-text"></label>
                </div>
            </div>

            <div id='kojiharu'>
                <div id='kojiharu-pic'></div>
                <label>Kojima Haruna</label>

                <div id='kojiharuButtons'>
                    <input type='button' value='Where am I Popular?' id='kojiharu-popularity-button'>
                </div>

                <div id='kojiharu-message'>
                    <label id='kojiharu-text'></label>
                </div>
            </div>

            <div id='takamina'>
                <div id='takamina-pic'></div>
                <label>Takahashi Minami</label>

                <div id='takaminaButtons'>
                    <input type='button' value='Where am I Popular?' id='takamina-popularity-button'>
                </div>

                <div id='takamina-message'>
                    <label id='takamina-text'></label>
                </div>
            </div>
        </div>

    </body>
</html>