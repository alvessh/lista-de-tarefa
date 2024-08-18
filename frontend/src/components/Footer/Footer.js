import { GitHub, Instagram } from "@mui/icons-material";
import React from "react";
import FooterCSS from "./Footer.module.css";

const Footer = () => {
    return (
        <div className={FooterCSS.Footer}>
            <div className={FooterCSS.footercontainer}>
                <h1>Treinamento de Dev</h1>
                <div className={FooterCSS.icons}>
                    <a
                        href="https://www.instagram.com/itamar.alvessh/"
                        target="_blank"
                        rel="noreferrer"
                    >
                        <Instagram className={FooterCSS.icon} />
                    </a>
                    <a
                        href="https://github.com/alvessh/programming-training"
                        target="_blank"
                        rel="noreferrer"
                    >
                        <GitHub className={FooterCSS.icon} />
                    </a>
                </div>
            </div>
        </div>
    );
};

export default Footer;