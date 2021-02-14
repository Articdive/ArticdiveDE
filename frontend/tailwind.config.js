module.exports = {
    purge: [],
    darkMode: 'class', // or 'media' or 'class'
    theme: {
        extend: {},
    },
    variants: {
        extend: {
            borderRadius: ['hover', 'focus'],
            borderWidth: ['hover', 'focus'],
            borderStyle: ['hover', 'focus'],
            display: ['group-hover', 'hover', 'focus'],
        }
    },
    plugins: [
        require('@tailwindcss/forms')
    ],
}